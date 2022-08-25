package aconex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.oracle.aconex.ReadFile;
import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.service.BuildDuration;
import com.oracle.aconex.service.ContractIDs;
import com.oracle.aconex.service.Customers;
import com.oracle.aconex.service.CustomersData;
import com.oracle.aconex.vo.CustomerVO;

public class ApplicationTest {

	CustomersData customersData = new CustomersData();
	ReadFile readFile = new ReadFile();
	String str = readFile.readFile(Appconstants.ORACLE_TEST);

	Customers customers = new Customers();
	List<CustomerVO> customerlist = customers.getCustomers(str);

	BuildDuration buildDuration = new BuildDuration();

	@Test
	public void falseGeoZone() {
		Set<String> st = new HashSet<String>();
		assertEquals(st, customersData.getCustomerIdsByGeoZone("false", customerlist));
	}

	@Test
	public void customerIdseGeoZone() {
		Set<String> st = new HashSet<String>();
		st.add("2343225");
		assertEquals(st, customersData.getCustomerIdsByGeoZone("us_east", customerlist));
	}

	@Test
	public void customerIdsContractId() {
		Set<String> st = new HashSet<String>();
		st.add("2343225");
		st.add("1233456");
		st.add("1223456");
		assertEquals(st, customersData.getCustomerIdsByContractId("2345", customerlist));
	}

	@Test
	public void falseCustomerIdsContractId() {
		Set<String> st = new HashSet<String>();
		st.clear();
		assertEquals(st, customersData.getCustomerIdsByContractId("us_east", customerlist));
	}
	
	@Test
	public void contractID() {
		ContractIDs contractIDs = new ContractIDs();
		Set<String> st = new HashSet<String>();
		st.add("2346");
		st.add("2345");
		assertEquals(st, contractIDs.getContractsIDs(customerlist));
	}

	@Test
	public void averageBuild() {
		Set<String> st = new HashSet<String>();
		st.clear();
		assertEquals(3445, buildDuration.getAvgBuild("us_east", customerlist));
	}
	
	@Test
	public void falseAverageBuild() {
		Set<String> st = new HashSet<String>();
		st.clear();
		assertEquals(3445, buildDuration.getAvgBuild("us_east", customerlist));
	}
	
	@Test
	public void falsefilePath() {
		ReadFile readFile = new ReadFile();
		assertEquals(null, readFile.readFile("false"));
	}


}  
