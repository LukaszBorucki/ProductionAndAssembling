package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.MachineUsage;

public class MachineUsageRepositoryImpl implements MachineUsageRepository {
    private static MachineUsageRepositoryImpl mInstance = new MachineUsageRepositoryImpl();
    private final Database mDatabase;

    private MachineUsageRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static MachineUsageRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveMachineUsage(List<MachineUsage> machineUsages) {
        mDatabase.saveMachineUsage(machineUsages);
    }

    @Override
    public void saveMachineUsage(MachineUsage machineUsage) {
        mDatabase.saveMachineUsage(machineUsage);
    }

    @Override
    public List<MachineUsage> getMachineUsageByMachineId(String id) {
        return mDatabase.getMachineUsageByMachineId(id);
    }
}
