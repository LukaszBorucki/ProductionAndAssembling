package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.Machine;

public interface MachineRepository {
    void saveMachine(Machine machine);

    void saveMachine(List<Machine> machines);

    List<Machine> getMachine();

    Machine getMachineById(String id);
}
