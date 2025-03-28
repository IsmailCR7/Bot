package org.hogwarts;

public class Aircraft {
    private final String vacuum;
    private final String mediaServer;
    private final String partition;
    private final String pram;

    public Aircraft(String vacuum, String mediaServer, String partition, String pram) {
        this.vacuum = vacuum;
        this.mediaServer = mediaServer;
        this.partition = partition;
        this.pram = pram;
    }

    // Геттеры
    public String getVacuum() {
        return vacuum;
    }

    public String getMediaServer() {
        return mediaServer;
    }

    public String getPartition() {
        return partition;
    }

        public String getPram() {
            return pram;
        }
    }
