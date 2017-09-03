package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.Machine;

public class MachineRepositoryImpl  implements MachineRepository {
    private static MachineRepositoryImpl mInstance = new MachineRepositoryImpl();
    private final Database mDatabase;

    private MachineRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }


    public static MachineRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveMachine(Machine machine) {
        mDatabase.saveMachine(machine);
    }

    @Override
    public void saveMachine(List<Machine> machines) {
        mDatabase.saveMachine(machines);
    }

    @Override
    public List<Machine> getMachine() {
        return mDatabase.getMachine();
    }

    @Override
    public Machine getMachineById(String id) {
        return mDatabase.getMachineById(id);
    }
}
