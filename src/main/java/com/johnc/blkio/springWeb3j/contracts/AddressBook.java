package com.johnc.blkio.springWeb3j.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class AddressBook extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061068b806100206000396000f3006080604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634ba79dfe811461006657806399900d1114610089578063a39fac121461011f578063d033c45614610184575b600080fd5b34801561007257600080fd5b50610087600160a060020a03600435166101eb565b005b34801561009557600080fd5b506100aa600160a060020a03600435166103c5565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100e45781810151838201526020016100cc565b50505050905090810190601f1680156101115780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561012b57600080fd5b5061013461047f565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610170578181015183820152602001610158565b505050509050019250505060405180910390f35b34801561019057600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610087958335600160a060020a03169536956044949193909101919081908401838280828437509497506104f29650505050505050565b600160a060020a033316600090815260208190526040812054905b818110156103c057600160a060020a033316600090815260208190526040902080548290811061023257fe5b600091825260209091200154600160a060020a03848116911614156103b857600160a060020a033316600090815260208190526040902054600110801561027b57506001820381105b1561030e57600160a060020a0333166000908152602081905260409020805460001984019081106102a857fe5b600091825260208083209091015433600160a060020a0390811684529183905260409092208054919092169190839081106102df57fe5b9060005260206000200160006101000a815481600160a060020a030219169083600160a060020a031602179055505b600160a060020a03331660009081526020819052604090208054600019840190811061033657fe5b60009182526020808320909101805473ffffffffffffffffffffffffffffffffffffffff1916905533600160a060020a031682528190526040902080549061038290600019830161055c565b50600160a060020a03338116600090815260016020908152604080832093871683529290529081206103b391610580565b6103c0565b600101610206565b505050565b33600160a060020a03908116600090815260016020818152604080842094861684529381529183902080548451600293821615610100026000190190911692909204601f810184900484028301840190945283825260609391929091908301828280156104735780601f1061044857610100808354040283529160200191610473565b820191906000526020600020905b81548152906001019060200180831161045657829003601f168201915b50505050509050919050565b600160a060020a033316600090815260208181526040918290208054835181840281018401909452808452606093928301828280156104e757602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116104c9575b505050505090505b90565b600160a060020a0333811660008181526020818152604080832080546001818101835591855283852001805496891673ffffffffffffffffffffffffffffffffffffffff19909716871790559383529281528282209382529283522082516103c0928401906105c7565b8154818355818111156103c0576000838152602090206103c0918101908301610645565b50805460018160011615610100020316600290046000825580601f106105a657506105c4565b601f0160209004906000526020600020908101906105c49190610645565b50565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061060857805160ff1916838001178555610635565b82800160010185558215610635579182015b8281111561063557825182559160200191906001019061061a565b50610641929150610645565b5090565b6104ef91905b80821115610641576000815560010161064b5600a165627a7a72305820f79953d23768d5fd80d266863d234c599a2d80231e64da1fcf27ed558b233aa00029";

    public static final String FUNC_REMOVEADDRESS = "removeAddress";

    public static final String FUNC_GETALIAS = "getAlias";

    public static final String FUNC_GETADDRESSES = "getAddresses";

    public static final String FUNC_ADDADDRESS = "addAddress";

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> removeAddress(String addr) {
        final Function function = new Function(
                FUNC_REMOVEADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getAlias(String addr) {
        final Function function = new Function(FUNC_GETALIAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getAddresses() {
        final Function function = new Function(FUNC_GETADDRESSES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addAddress(String addr, String alias) {
        final Function function = new Function(
                FUNC_ADDADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr), 
                new org.web3j.abi.datatypes.Utf8String(alias)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
