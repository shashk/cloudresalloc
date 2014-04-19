import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;


public class CloudSimApp1 {

	/** The cloudlet list. */
	private static List<Cloudlet> cloudletList;

	/** The vmlist. */
	private static List<Vm> vmlist;

	/**
	 * Creates main() to run this example
	 */
	public static void main(String[] args) {

		Log.printLine("Starting CloudSimExample2...");

	        try {
	        	// First step: Initialize the CloudSim package. It should be called
	            	// before creating any entities.
	            	int num_user = 8;   // number of cloud users
	            	Calendar calendar = Calendar.getInstance();
	            	boolean trace_flag = false;  // mean trace events

	            	// Initialize the CloudSim library
	            	CloudSim.init(num_user, calendar, trace_flag);

	            	// Second step: Create Datacenters
	            	//Datacenters are the resource providers in CloudSim. We need at list one of them to run a CloudSim simulation
	            	Datacenter datacenter0 = createDatacenter("Datacenter_0");
                        Datacenter datacenter1 = createDatacenter("Datacenter_1");
                        Datacenter datacenter2 = createDatacenter("Datacenter_2");
                        Datacenter datacenter3 = createDatacenter("Datacenter_3");

	            	//Third step: Create Broker
	            	CustomBroker broker = createBroker();
	            	int brokerId = broker.getId();

	            	//Fourth step: Create one virtual machine
	            	vmlist = new ArrayList<Vm>();

	            	//VM description
	            	int vmid = 0;
	            	int mips = 250;
                        double costpersec=20.0;
                        long size = 10000; //image size (MB)
	            	int ram = 512; //vm memory (MB)
	            	long bw = 1000;
	            	int pesNumber = 1; //number of cpus
	            	String vmm = "Xen"; //VMM name

	            	//create two VMs
	            	Vm vm1 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        costpersec=28.0;
                        mips=450;
                        ram = 768;
                        bw = 512;
	            	vmid++;
	            	Vm vm2 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        costpersec=25.0;
                        mips =580;
                        ram = 256;
                        bw = 768;
                        vmid++;
	            	Vm vm3 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        costpersec=30.0;
                        mips =300;
                        ram = 768;
                        bw = 512;
                        vmid++;
	            	Vm vm4 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        costpersec=22.0;
                        mips =280;
                        ram = 1000;
                        bw = 128;
                        vmid++;
	            	Vm vm5 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        vmid++;
	            	costpersec=50.0;
                        mips =220;
                        ram = 128;
                        bw = 128;                        
	            	
//                        Vm vm6 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	costpersec=22.0;
//                        mips =280;
//                        ram = 2048;
//                        bw = 64;
//                        Vm vm7 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm8 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm9 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm10 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm11 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm12 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm13 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm14 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm15 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
//                        vmid++;
//	            	Vm vm16 = new Vm(vmid, brokerId, mips,costpersec, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
                        

	            	//add the VMs to the vmList
	            	vmlist.add(vm1);
	            	vmlist.add(vm2);
                        vmlist.add(vm3);
                        vmlist.add(vm4);
                        vmlist.add(vm5);
                        
//                        vmlist.add(vm6);
//                        vmlist.add(vm7);
//                        vmlist.add(vm9);
//                        vmlist.add(vm10);
//                        vmlist.add(vm11);
//                        vmlist.add(vm12);
//                        vmlist.add(vm13);
//                        vmlist.add(vm14);
//                        vmlist.add(vm15);
//                        vmlist.add(vm16);                        
                        
                        

	            	//submit vm list to the broker
	            	broker.submitVmList(vmlist);


	            	//Fifth step: Create two Cloudlets
	            	cloudletList = new ArrayList<Cloudlet>();

	            	//Cloudlet properties
	            	int id = 0;
	            	pesNumber=1;
	            	long length = 2500;
	            	long fileSize = 300;
	            	long outputSize = 450;
	            	UtilizationModel utilizationModel = new UtilizationModelFull();
                        double wt=1;
                        double wm=0;

	            	Cloudlet cloudlet1 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet1.setUserId(brokerId);

	            	id++;                        
	            	pesNumber=1;
	            	length = 2800;
	            	fileSize = 600;
	            	outputSize = 600;
	            	Cloudlet cloudlet2 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet2.setUserId(brokerId);
                        id++;                        
	            	pesNumber=1;
	            	length = 1250;
	            	fileSize = 800;
	            	outputSize = 800;
	            	Cloudlet cloudlet3 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet3.setUserId(brokerId);
                        id++;                        
	            	pesNumber=1;
	            	length = 2480;
	            	fileSize = 300;
	            	outputSize = 300;
	            	Cloudlet cloudlet4 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet4.setUserId(brokerId);
                        id++;
                        pesNumber=1;
	            	length = 7000;
	            	fileSize = 500;
	            	outputSize = 500;
	            	Cloudlet cloudlet5 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet5.setUserId(brokerId);
                        id++;
                        pesNumber=1;
	            	length = 1500;
	            	fileSize = 500;
	            	outputSize = 500;
                        Cloudlet cloudlet6 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet6.setUserId(brokerId);
                        id++;
                        pesNumber=1;
	            	length = 800;
	            	fileSize = 500;
	            	outputSize = 500;
	            	Cloudlet cloudlet7 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet7.setUserId(brokerId);
                        id++;
                        pesNumber=1;
	            	length = 7500;
	            	fileSize = 500;
	            	outputSize = 500;
	            	Cloudlet cloudlet8 = new Cloudlet(wt, wm, id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
	            	cloudlet8.setUserId(brokerId);
                        
                        

	            	//add the cloudlets to the list
	            	cloudletList.add(cloudlet1);
	            	cloudletList.add(cloudlet2);
                        cloudletList.add(cloudlet3);
                        cloudletList.add(cloudlet4);
                        cloudletList.add(cloudlet5);
                        
                        cloudletList.add(cloudlet6);
                        cloudletList.add(cloudlet7);
                        cloudletList.add(cloudlet8);
                        

	            	//submit cloudlet list to the broker
	            	broker.submitCloudletList(cloudletList);


	            	//bind the cloudlets to the vms. This way, the broker
	            	// will submit the bound cloudlets only to the specific VM
	            	
                        //broker.bindCloudletToVm(cloudlet1.getCloudletId(),vm1.getId());
	            	//broker.bindCloudletToVm(cloudlet2.getCloudletId(),vm2.getId());

	            	// Sixth step: Starts the simulation
	            	CloudSim.startSimulation();


	            	// Final step: Print results when simulation is over
	            	List<Cloudlet> newList = broker.getCloudletReceivedList();

	            	CloudSim.stopSimulation();

	            	printCloudletList(newList);

	            	//Print the debt of each user to each datacenter
	    	    	//datacenter0.printDebts();

	            	Log.printLine("CloudSimExample2 finished!");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            Log.printLine("The simulation has been terminated due to an unexpected error");
	        }
	    }

		private static Datacenter createDatacenter(String name){

	        // Here are the steps needed to create a PowerDatacenter:
	        // 1. We need to create a list to store
	    	//    our machine
	    	List<Host> hostList = new ArrayList<Host>();

	        // 2. A Machine contains one or more PEs or CPUs/Cores.
	    	// In this example, it will have only one core.
	    	List<Pe> peList = new ArrayList<Pe>();

	    	int mips = 1000;

	        // 3. Create PEs and add these into a list.
	    	peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating

	        //4. Create Host with its id and list of PEs and add them to the list of machines
	        int hostId=0;
	        int ram = 2048; //host memory (MB)
	        long storage = 1000000; //host storage
	        int bw = 10000;

	        hostList.add(
	    			new Host(
	    				hostId,
	    				new RamProvisionerSimple(ram),
	    				new BwProvisionerSimple(bw),
	    				storage,
	    				peList,
	    				new VmSchedulerTimeShared(peList)
	    			)
	    		); // This is our machine
                hostId++;
                hostList.add(
	    			new Host(
	    				hostId,
	    				new RamProvisionerSimple(ram),
	    				new BwProvisionerSimple(bw),
	    				storage,
	    				peList,
	    				new VmSchedulerTimeShared(peList)
	    			)
	    		);
                hostId++;
                hostList.add(
	    			new Host(
	    				hostId,
	    				new RamProvisionerSimple(ram),
	    				new BwProvisionerSimple(bw),
	    				storage,
	    				peList,
	    				new VmSchedulerTimeShared(peList)
	    			)
	    		);
               /* hostId++;
                hostList.add(
	    			new Host(
	    				hostId,
	    				new RamProvisionerSimple(ram),
	    				new BwProvisionerSimple(bw),
	    				storage,
	    				peList,
	    				new VmSchedulerTimeShared(peList)
	    			)
	    		);
*/
	        // 5. Create a DatacenterCharacteristics object that stores the
	        //    properties of a data center: architecture, OS, list of
	        //    Machines, allocation policy: time- or space-shared, time zone
	        //    and its price (G$/Pe time unit).
	        String arch = "x86";      // system architecture
	        String os = "Linux";          // operating system
	        String vmm = "Xen";
	        double time_zone = 10.0;         // time zone this resource located
	        double cost = 3.0;              // the cost of using processing in this resource
	        double costPerMem = 0.05;		// the cost of using memory in this resource
	        double costPerStorage = 0.001;	// the cost of using storage in this resource
	        double costPerBw = 0.0;			// the cost of using bw in this resource
	        LinkedList<Storage> storageList = new LinkedList<Storage>();	//we are not adding SAN devices by now

	        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
	                arch, os, vmm, hostList, time_zone, cost, costPerMem, costPerStorage, costPerBw);


	        // 6. Finally, we need to create a PowerDatacenter object.
	        Datacenter datacenter = null;
	        try {
	            datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return datacenter;
	    }

	    //We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
	    //to the specific rules of the simulated scenario
	    private static CustomBroker createBroker(){

	    	CustomBroker broker = null;
	        try {
			broker = new CustomBroker("Broker");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	    	return broker;
	    }

	    /**
	     * Prints the Cloudlet objects
	     * @param list  list of Cloudlets
	     */
	    private static void printCloudletList(List<Cloudlet> list) {
	        int size = list.size();
	        Cloudlet cloudlet;

	        String indent = "    ";
	        Log.printLine();
	        Log.printLine("========== OUTPUT ==========");
	        Log.printLine("Cloudlet ID" + indent + "STATUS" + indent +
	                "Data center ID" + indent + "VM ID" + indent + "Time" + indent + "Start Time" + indent + "Finish Time");

	        DecimalFormat dft = new DecimalFormat("###.##");
	        for (int i = 0; i < size; i++) {
	            cloudlet = list.get(i);
	            Log.print(indent + cloudlet.getCloudletId() + indent + indent);

	            if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS){
	                Log.print("SUCCESS");

	            	Log.printLine( indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId() +
	                     indent + indent + dft.format(cloudlet.getActualCPUTime()) + indent + indent + dft.format(cloudlet.getExecStartTime())+
                             indent + indent + dft.format(cloudlet.getFinishTime()));
	            }
	        }

	    }
}
