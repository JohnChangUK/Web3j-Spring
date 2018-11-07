
import com.johnc.blkio.springWeb3j.contracts.AddressBook;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    private static Web3j web3j;

    private static final String PRIVATE_KEY = "637ebd72df5bb55a5d843741ab75e84f091e2ea7891c43a8db3b509032cc9c27";

    public Main(Web3j web3j) {
        this.web3j = web3j;
    }

    private final static String RECIPIENT = "0xd20973DEE7602f8AEA53ea2520266Dd7C16FCd4D";

    public static void main(String[] args) throws Exception {
        Main main = new Main(Web3j.build(new HttpService()));
        Credentials credentials = main.getCredentialsFromPrivateKey(PRIVATE_KEY);

        String contractAddress = getContractAddress(credentials);

        AddressBook addressBook = loadContract(contractAddress, credentials);

        addressBook
                .addAddress("0x753ee9D35706350d25845B3d9fDF31B9924e0Ce8", "FirstAddr")
                .send();

        addressBook
                .addAddress("0x42899721D24578dca3E47e94819D08e8b7b35477", "SecondAddr")
                .send();

        addressBook
                .addAddress("0xcfab3beF2F753C750EB5B746b56e8e813b030Ea8", "ThirdAddr")
                .send();

        removeAddress(addressBook, "0x753ee9D35706350d25845B3d9fDF31B9924e0Ce8");
        printAddresses(addressBook);

        transferEther(credentials);
        getContractAddress(credentials);

    }

    private static void printAddresses(AddressBook addressBook) throws Exception {

        for (Object address : addressBook.getAddresses().send()) {
            String alias = addressBook.getAlias((String) address).send();
            System.out.println("Address : " + address + " Alias: " + alias);
        }
    }

    private static void removeAddress(AddressBook addressBook, String addresss) throws Exception {

        addressBook.removeAddress(addresss).send();
        System.out.println("Removed address: " + addresss);
    }

    private static void transferEther(Credentials credentials) {
        TransactionManager manager = new RawTransactionManager(
                web3j,
                credentials
        );

        Transfer transfer = new Transfer(web3j, manager);
        TransactionReceipt receipt = null;

        try {
            receipt = transfer.sendFunds(
                    RECIPIENT,
                    BigDecimal.ONE,
                    Convert.Unit.ETHER,
                    DefaultGasProvider.GAS_PRICE,
                    DefaultGasProvider.GAS_LIMIT
            ).send();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String transactionHash = receipt.getTransactionHash();
        System.out.println("Transaction = " + transactionHash);
    }

    private static AddressBook loadContract(String contractAddress, Credentials credentials) {
        return AddressBook.load(contractAddress, web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
    }

    private static String getContractAddress(Credentials credentials) {
        String contractAddress = null;

        try {
            contractAddress = AddressBook.deploy(
                    web3j, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT)
                    .send()
                    .getContractAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Contract Address is: " + contractAddress);
        return contractAddress;
    }

    private Credentials getCredentialsFromPrivateKey(String privateKey) {
        return Credentials.create(privateKey);
    }

    private Credentials getCredentialsFromWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "passphrase",
                "wallet/path"
        );
    }

    private String getWeb3jVersion() {
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Client Version: " + web3ClientVersionString);
        return web3ClientVersionString;
    }
}
