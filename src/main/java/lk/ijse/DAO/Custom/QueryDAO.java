package lk.ijse.DAO.Custom;

import lk.ijse.DAO.SuperDAO;
import lk.ijse.Dto.TransactionDTO;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<TransactionDTO> getAllTransaction();
}
