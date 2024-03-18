package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DAO.CrudDAO;
import lk.ijse.Dto.BranchDTO;

import java.util.List;

public interface BranchBO extends SuperBO {
    List<BranchDTO> getAll();
    boolean saveBranch(BranchDTO branchDTO);
    boolean updateBranch(BranchDTO branchDTO);
    BranchDTO getBranch(String branchId);
    boolean deleteBranch(String branchId);
    String getNextId();
}
