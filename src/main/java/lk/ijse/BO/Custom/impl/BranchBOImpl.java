/* Created By Sithira Roneth
 * Date :3/18/24
 * Time :10:45
 * Project Name :ORM
 * */
package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.BranchBO;
import lk.ijse.DAO.Custom.BranchDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.BranchDTO;
import lk.ijse.Entity.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.BRANCH);

    @Override
    public List<BranchDTO> getAll() {
        List<BranchDTO> branchDTOS = new ArrayList<>();
        List<Branch> branches = branchDAO.getAll();
        if (branches != null) {
            for (Branch branch : branches) {
                branchDTOS.add(new BranchDTO(
                        branch.getBranchId(),
                        branch.getBranchName()
                ));
            }
        }
        return branchDTOS;
    }

    @Override
    public boolean saveBranch(BranchDTO branchDTO) {
        return branchDAO.save(new Branch(
                branchDTO.getBranchId(),
                branchDTO.getBranchName()
        ));
    }

    @Override
    public boolean updateBranch(BranchDTO branchDTO) {
        return branchDAO.update(new Branch(
                branchDTO.getBranchId(),
                branchDTO.getBranchName()
        ));
    }

    @Override
    public BranchDTO getBranch(String branchId) {
        return null;
    }

    @Override
    public boolean deleteBranch(String branchId) {
        return branchDAO.delete(branchId);
    }

    @Override
    public String getNextId() {
        String id = branchDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("BR","")) + 1;
        return String.format("BR%02d",newId);
    }
}
