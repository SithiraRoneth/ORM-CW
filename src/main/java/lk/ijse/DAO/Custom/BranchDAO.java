/* Created By Sithira Roneth
 * Date :3/18/24
 * Time :10:48
 * Project Name :ORM
 * */
package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.Entity.Branch;

public interface BranchDAO extends CrudDAO<Branch,String> {
    String getNextId();
}
