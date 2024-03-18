/* Created By Sithira Roneth
 * Date :3/18/24
 * Time :10:43
 * Project Name :ORM
 * */
package lk.ijse.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class BranchDTO {
    private String branchId;
    private String branchName;

    public BranchDTO(String branchId) {
        this.branchId = branchId;
    }
}