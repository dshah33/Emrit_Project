### Second part (Optional)

This is the Second Part of the POC set up file.

____

#### Prerequisites
1. [Java 1.8+](https://www.oracle.com/in/java/technologies/javase/jdk14-archive-downloads.html#license-lightbox) - Jmeter Dependency
2. [Jmeter](https://jmeter.apache.org/download_jmeter.cgi) - Script Editor
3. GitHub - Repository Management Tool
4. API Key from [WatchData](https://www.watchdata.io/)

#### Importing Project to Local
1. Open Command Prompt/Terminal in your machine.
2. Navigate your Command Prompt/Terminal to the folder where you need to clone the repository.
3. Once navigate to folder, enter below command to clone the repository.
```
git clone <repository url>
```
4. It may ask to enter your GitHub credentials if you're opening first time.
5. It may take sometime to download the complete repository to your local.

#### API Details

- In the performance testing, WatchData APIs are tested, which you can find in below link.
  https://docs.watchdata.io/blockchain-apis/ethereum-api

**NOTE** - You'll need API Key from the WatchData to run the performance tests on API

#### Project Setup
1. Open Jmeter once you downloaded from `bin > jmeter.bat`
2. Import the jmx file from the `<Project Folder> --> scripts`
3. In the file, go to `WatchData > User Defined Variables` and in the `api_key` enter your API Key from the WatchData

#### Test Details

- In the .jmx script, we have automated 4 [Ethereum APIs](https://docs.watchdata.io/blockchain-apis/ethereum-api)

1. [eth_blockNumber](https://docs.watchdata.io/blockchain-apis/ethereum-api/eth_blocknumber) - Returns the number of the most recent block. (this will extract block number from response)
2. [eth_getBlockByHash](https://docs.watchdata.io/blockchain-apis/ethereum-api/eth_getblockbyhash) - Returns information about a block by hash.
3. [eth_getBlockByNumber](https://docs.watchdata.io/blockchain-apis/ethereum-api/eth_getblockbynumber) - Returns information about a block by block number. (this is will use extracted block num from #1 in the request body)
4. [eth_getTransactionByHash](https://docs.watchdata.io/blockchain-apis/ethereum-api/eth_gettransactionbyhash) - Returns the information about a transaction requested by transaction hash.

#### Test Execution

- For the test execution, open Command Prompt/Terminal in the `bin` folder of the Jmeter
- After opening the Command Prompt/Terminal, execute the below command and wait till it's completed
```
jmeter -n -t <path of the jmx file> -l <path for the csv result> -e -o <path for the reports folder>
```

where...
    
    -  <path of the jmx file> - Path of the .jmx file location
    -  <path for the csv result> - Path of the location where you need to store csv test results (i.e. C:\Users\<username>\Desktop\results.csv)
    -  <path for the reports folder> - Path of the location where you need to store the HTML reports. (i.e. C:\Users\<username>\Desktop\Results)

#### Test Execution Report

- For the demo purpose, we have executed the APIs for the 1, 5 and 10 users and shared the report in `Performance Report` folder with analysis