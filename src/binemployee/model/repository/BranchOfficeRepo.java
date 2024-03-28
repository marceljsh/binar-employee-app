package binemployee.model.repository;

import binemployee.model.entity.BranchOffice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BranchOfficeRepo {

    private final Map<Long, BranchOffice> branchOfficeStore;
    private final AtomicLong sequence = new AtomicLong();

    public BranchOfficeRepo() {
        branchOfficeStore = new HashMap<>();
    }

    public void save(BranchOffice branchOffice) {
        if (branchOffice.getId() == null) {
            branchOffice.setId(sequence.incrementAndGet());
        }
        branchOfficeStore.put(branchOffice.getId(), branchOffice);
    }

    public BranchOffice findById(Long id) {
        return branchOfficeStore.get(id);
    }

    public Collection<BranchOffice> findAll() {
        return branchOfficeStore.values();
    }
}
