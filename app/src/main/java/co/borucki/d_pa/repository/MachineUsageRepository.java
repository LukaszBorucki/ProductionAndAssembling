package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.MachineUsage;

public interface MachineUsageRepository {
    void saveMachineUsage(List<MachineUsage> machineUsages);

    void saveMachineUsage(MachineUsage machineUsage);

    List<MachineUsage> getMachineUsageByMachineId(String id);

}
