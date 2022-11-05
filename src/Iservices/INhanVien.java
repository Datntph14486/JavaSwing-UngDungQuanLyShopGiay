/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import java.util.List;

/**
 *
 * @author Vuong_Ahihiiii
 */
public interface INhanVien<Entity, Key> {

    public void insert(Entity entity); // Dua 1 entity dua vao database

    public void update(Entity entity);

    public void delete(Key key);

    public List<Entity> selectALL();

    public Entity selectByID(Key key); // Dua 1 key tra ve 1 thuc the

    List<Entity> selectBySQL(String sql, Object... args);
    // Dua 1 cau lenh SQL va danh sach tham so, tra ve  danh sach thuc the
    // protected: phuong thuc chi de class con su dung
}
