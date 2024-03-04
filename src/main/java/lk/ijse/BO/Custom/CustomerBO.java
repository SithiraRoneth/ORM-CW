package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDTO> getAll();
    boolean saveCustomer(CustomerDTO customerDTO);
    boolean updateCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomer(String cusId);
    boolean deleteCustomer(String cusId);
    String getNextId();
}
