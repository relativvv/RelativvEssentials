package de.relativv.relativvessentials.nick;

import de.relativv.relativvessentials.utils.MySQL;
import org.bukkit.OfflinePlayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NickAPI {

    public NickAPI() {
    }

    public static String prefix = "§8▌ §5Nick §8» §r";


    public void createTables() {
        try {
            MySQL.getCon().prepareStatement("CREATE TABLE IF NOT EXISTS NickSystem (ID int(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY, UUID VARCHAR(61), enabled boolean)").executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }


    public boolean userExists(OfflinePlayer p) {
        try {
            PreparedStatement ps = MySQL.getCon().prepareStatement("SELECT UUID from NickSystem WHERE UUID = ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public void createUser(OfflinePlayer p) {
        if(!userExists(p)) {
            try {
                PreparedStatement ps = MySQL.getCon().prepareStatement("INSERT INTO NickSystem (UUID, enabled) VALUES (?, ?)");
                ps.setString(1, p.getUniqueId().toString());
                ps.setBoolean(2, false);
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    public boolean isNicked(OfflinePlayer p) {
        try {
            PreparedStatement ps = MySQL.getCon().prepareStatement("SELECT enabled FROM NickSystem WHERE UUID = ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getBoolean("enabled");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }



    public void setNicked(OfflinePlayer p, boolean value) {
        if(userExists(p)) {
            try {
                PreparedStatement ps = MySQL.getCon().prepareStatement("UPDATE NickSystem SET enabled = ? WHERE UUID = ?");
                ps.setBoolean(1, value);
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            createUser(p);
            setNicked(p, value);
        }
    }

}
