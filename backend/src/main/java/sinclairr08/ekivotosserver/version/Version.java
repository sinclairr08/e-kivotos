package sinclairr08.ekivotosserver.version;

import java.util.List;

public class Version {
    private String versionString;

    private String releaseDate;

    private List<String> updates;

    public Version(String versionString, String releaseDate, List<String> updates) {
        this.versionString = versionString;
        this.releaseDate = releaseDate;
        this.updates = updates;
    }

    public String getVersionString() {
        return versionString;
    }

    public void setVersionString(String versionString) {
        this.versionString = versionString;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getUpdates() {
        return updates;
    }

    public void setUpdates(List<String> updates) {
        this.updates = updates;
    }
}
