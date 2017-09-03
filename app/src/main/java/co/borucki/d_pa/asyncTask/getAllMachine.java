package co.borucki.d_pa.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.MachineDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.MachineRepository;
import co.borucki.d_pa.repository.MachineRepositoryImpl;

public class getAllMachine extends AsyncTask<Void, Void, List<MachineDTO>> {
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    private MachineRepository mMachineRepository = MachineRepositoryImpl.getInstance();

    public getAllMachine() {
    }

    @Override
    protected List<MachineDTO> doInBackground(Void... params) {
        String link = "http://www.diamon.pl/api/production/getAllMachine/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, MachineDTO[].class));
    }

    @Override
    protected void onPostExecute(List<MachineDTO> machineDTOs) {
        mMachineRepository.saveMachine(Mapper.fromMachineDTOToMachine(machineDTOs));
    }
}
