package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.CustomerBO;
import lk.ijse.Dto.CustomerDTO;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    @Override
    public List<CustomerDTO> getAll() {
        return null;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public CustomerDTO getCustomer(String cusId) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String cusId) {
        return false;
    }

    @Override
    public String getNextId() {
        return null;
    }
}
