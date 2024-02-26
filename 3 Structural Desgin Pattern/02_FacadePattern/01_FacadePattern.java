//Unified Interface
interface IHistory {

    //create connection to db
    void createConnection();

    void generateCSVReport();

    void generatePDFReport();
}

//interfaces that extends unified interface
interface IOracleDB extends IHistory {

    //special oracle methods needed
    void getOracleConnection();

}

interface IHdfsDB extends IHistory {

    //special oracle methods needed
    void getHDFSConnection();

}

// sub-system 1
class OracleDB implements IOracleDB {

    @Override
    public void createConnection() {
        this.getOracleConnection();
    }

    @Override
    public void generateCSVReport() {
        System.out.println("Generating CSV report from Oracle");
    }

    @Override
    public void generatePDFReport() {
        System.out.println("Generating PDF report from Oracle");
    }

    @Override
    public void getOracleConnection() {
        System.out.println("connecting to the oracle DB");

    }
}

// sub-system 1
class HdfsDB implements IHdfsDB {

    @Override
    public void createConnection() {
        this.getHDFSConnection();
    }

    @Override
    public void generateCSVReport() {
        System.out.println("Generating CSV report from HDFS");
    }

    @Override
    public void generatePDFReport() {
        System.out.println("Generating pdf report from HDFS");
    }

    @Override
    public void getHDFSConnection() {
        System.out.println("connecting to the HDFS DB");

    }
}

//facade class
class FacadeInfo {
    public void getInfo(String db, String typeOfReport) {

        if (db.equalsIgnoreCase("hdfs")) {
            IHdfsDB hdfsDB = new HdfsDB();
            hdfsDB.getHDFSConnection();
            if (typeOfReport.equalsIgnoreCase("csv")) {
                hdfsDB.generateCSVReport();
            } else {
                hdfsDB.generatePDFReport();
            }
        } else {
            IOracleDB oracleDB = new OracleDB();
            oracleDB.getOracleConnection();

            if (typeOfReport.equalsIgnoreCase("csv")) {
                oracleDB.generateCSVReport();
            } else {
                oracleDB.generatePDFReport();
            }

        }
    }
}

//client
class FacadeMain {
    public static void main(String[] args) {

        FacadeInfo facadeInfo = new FacadeInfo();

        //for historical
        facadeInfo.getInfo("hdfs", "pdf");

        //for historical
        facadeInfo.getInfo("oracle", "cvs");
    }
}