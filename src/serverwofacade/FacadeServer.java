package serverwofacade;

public class FacadeServer {
    private static ScheduleServer scheduleServer;
    public static FacadeServer getFacade() {
        FacadeServer facadeServer = new FacadeServer();
        scheduleServer = new ScheduleServer();
        return facadeServer;
    }
    public void start() {
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }
    public void stop() {
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}