/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.KhachHang;
import java.util.List;

/**
 *
 * @author Thang
 */
public interface IKhachHang<Entity, Key> {

    public void insert(Entity entity);
    public void update(Entity entity);
    public List<Entity> selectALL();
    public Entity selectByID(Key key); 
    List<Entity> selectBySQL(String sql, Object... args);
    
   

}