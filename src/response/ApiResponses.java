/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

/**
 *
 * @author hocgioinhatlop
 */
public class ApiResponses<T> {
    public int err;
    public String msg;
    public T data;
    public long timestamp;

    public ApiResponses() {
    }

    public ApiResponses(int err, String msg, T data, long timestamp) {
        this.err = err;
        this.msg = msg;
        this.data = data;
        this.timestamp = timestamp;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    

}
