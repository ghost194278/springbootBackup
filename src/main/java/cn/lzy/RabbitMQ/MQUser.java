package cn.lzy.RabbitMQ;

/**
 * @author 江梅铭
 * @date 10/21/2023 11:17 AM
 */
public class MQUser {
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + '}';
    }
}
