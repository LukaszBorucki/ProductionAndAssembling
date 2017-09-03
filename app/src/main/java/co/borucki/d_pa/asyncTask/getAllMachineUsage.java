package co.borucki.d_pa.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.MachineUsageDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.MachineUsageRepository;
import co.borucki.d_pa.repository.MachineUsageRepositoryImpl;

public class getAllMachineUsage extends AsyncTask<Void, Void, List<MachineUsageDTO>> {
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    private MachineUsageRepository mMachineUsageRepository = MachineUsageRepositoryImpl.getInstance();

    public getAllMachineUsage() {
    }

    @Override
    protected List<MachineUsageDTO> doInBackground(Void... params) {
        String link = "http://www.diamon.pl/api/production/getAllMachine/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, MachineUsageDTO[].class));
    }

    @Override
    protected void onPostExecute(List<MachineUsageDTO> machineUsageDTOs) {
        mMachineUsageRepository.saveMachineUsage(Mapper.fromMachineUsageDTOToMachineUsage(machineUsageDTOs));
    }
}
