package com.alsjava.courses.posdemoandroid.model.communication.response;

/**
 * Created by aluis on 11/9/19.
 */
public class LoginResponse extends Response {

    private String session;
    private Long terminal;
    private String terminalName;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Long getTerminal() {
        return terminal;
    }

    public void setTerminal(Long terminal) {
        this.terminal = terminal;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }
}
