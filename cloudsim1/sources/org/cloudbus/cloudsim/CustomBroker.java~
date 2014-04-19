//package org.cloudbus.cloudsim.CustomBroker;

import java.util.Collections;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.core.CloudSimTags;
import org.cloudbus.cloudsim.core.SimEvent;
import org.cloudbus.cloudsim.lists.VmList;

import org.cloudbus.cloudsim.lists.VmList;
import org.cloudbus.cloudsim.lists.CloudletList;

//import java.util.TimeComparator;
import java.util.*;




public class CustomBroker extends DatacenterBroker {

	/** The cloudlets submitted. */
	private int cloudletsSubmitted=0;
	//private boolean firstrun = true;
	Cloudlet[] c1;
	
        int M,N;
        
        double exectime;
  		double utility;
  		double wm1;
  		double wt1;
  		double capacity;
  		double length;
	
	   	
	Queue <Cloudlet> rqueue1;
	Queue <Cloudlet> rqueue2;
	Queue <Cloudlet> rqueue3;
	Queue <Cloudlet> rqueue4;
	Queue <Cloudlet> rqueue5;
	
	//boolean[] occupation = null;
        public CustomBroker(String name) throws Exception {
		super(name);
                
		int i=0,j=0;

		for (Cloudlet c : getCloudletList())
        {
  			c1[i++] = c;
        }       
	}
	
	public double getwm1()
	{
		return 0.50;
	}
	public double getwt1()
	{
		return 0.50;
	}
	
	
	
	
	public double[] CreateUtil()
    {
    	int i=0,j=0;
		N = getVmList().size();
		System.out.println("Cols: " + N);
		M = getCloudletList().size();
		System.out.println("Rows: " + M);
    	double[] UM = new double[M*N];
        for(Cloudlet c : getCloudletList())
		{
        	j=0;
			for(Vm vm : getVmList())
        	{
        		//UM[i][j]=getUtility( c.getCloudletId() , vm.getId() );  
            	wm1 = c.getwm();
    			wt1 = c.getwt();
    			capacity = vm.getMips()*vm.getNumberOfPes()+vm.getRam()*vm.getBw();
				length = c.getCloudletTotalLength();
    			UM[i*N+j] = 10 / ((wm1*(vm.getcostpersec() * (length/capacity) ) ) + (wt1*(length/capacity) ) );
    			System.out.println("UM[" + i + "]["+ j + "] = " + UM[i*N+j] + "	" );	
            	j++;
        	}
        	i++;
		}
        
        return UM;
    }


   //get the local maximum value

	public value LocalMax(double[] UM)
        {
			double[] max = new double[M];
			int[] cntr = new int[M];
			int[] row = new int[M];
			int[] col = new int[M];
			int[] vmarray = new int[N];
            int i,j;
            Vm vm;
                for(i=0;i<M;i++)
                {
						max[i]=UM[i*N];
                        cntr[i]=0;
						System.out.println(UM[i*N]);
						for(j=0;j<N;j++)
                        {
								if(UM[i*N+j]>=max[i])
                                {
                                        max[i]=UM[i*N+j];
                                        row[i]=i;
                                        col[i]=j;
                                        cntr[j] = 1;
										System.out.println("LocalMax[" + i + "] = " + max[i] +"( "+ row[i] + ", " + col[i] + ")");
										vmarray[j] = row[i];
										System.out.println("vmarray[" + j + "] = " + row[i]);
                                }
                        }
                }
				value m = new value(max,row,col,cntr,vmarray);
                return m;
        }

//search and retrieve the global maximum value
        
        public value GlobalMax(value Loc,double[] UM)
        {
				double[] colmax = new double[N];
				int[] cntrg = new int[N];
				int[] rowg = new int[N];
				int[] colg = new int[N];
				double[] Local = Loc.n;
				int[] row = Loc.r;
				int[] col = Loc.c;
				int[] cntr = Loc.cn;
				int[] vmarray = Loc.va;
				cntrg = cntr;

                int i,j;
                for(j=0;j<N;j++)
                {

                        cntrg[j]=0;
                        for(i=0;i<Local.length;i++)
                        {

                                if(col[i]==j)
                                {
                                        if(cntrg[j]==0)
                                        {

						colmax[j]=Local[i];
                                                rowg[j]=row[i];
                                                colg[j]=col[i];
                                                cntrg[j] = 1;
						cntr[i] = 1;

                                                /*vmIndex = j;
                                                vm = getVmsCreatedList().get(vmIndex);
                                        	System.out.println("Resource #" + j + " has been 							scheduled to execute Request #" + i);
                                                c1[colmax[j].row].setVmId(j); */
                                         	
						vmarray[colg[j]]=rowg[j];
						System.out.println("vmarray[" + colg[j] + "] = " + rowg[j]);
                                        }
                                        else if((Local[i] >= colmax[j]) && (cntrg[j] > 0))
                                        {
                                                colmax[j]=Local[i];
                                                rowg[j]=row[i];
                                                colg[j]=col[i];
                                                cntrg[j]=1;
						cntr[i] = 1;
						Local[i] = 0;
					        /*
						vmIndex = j;
					        vm = getVmsCreatedList().get(vmIndex);
                                                System.out.println("Resource #" + j + " has been 							scheduled to execute Request #" + i);
						cloudlet.setVmId(j);
						*/

                                        	vmarray[colg[j]]=rowg[j];
						System.out.println("vmarray[" + colg[j] + "] = " + rowg[j]);
                                         }
                                        else if(Local[i] == colmax[j])
                                        {
						int r=rowg[j];
						
						if(j==1) { rqueue1.add(c1[r]); }
                                           	if(j==2) { rqueue2.add(c1[r]); }
                                           	if(j==3) { rqueue3.add(c1[r]); }
                                           	if(j==4) { rqueue4.add(c1[r]); }
                                           	if(j==5) { rqueue5.add(c1[r]); }
			       							
                            			System.out.println("Request #" + i + " for Resource #" + j + " has been added to the queue.");
                     		               cntrg[j]++;
			        
                                        }
                                }
                        }
                }
                for(j=0;j<N;j++)
                {
                	System.out.println("cntrg[" + j + "] = " + cntrg[j]);
                }
				for(j=0;j<N;j++)
				{
					cntr[vmarray[j]] = 1;
				}
                
                for(j=0;j<N;j++)
                {
                        if(cntrg[j]==0)
                        {
                                colmax[j]=0.0; // Check if utility value for any cloudlet, vm pair is always greater than ZERO
                                //colmax[j].row=0;
                                //colmax[j].col=j;

                                for(i=0;i<M;i++)
                                {
                                        if(UM[i*N+j] > colmax[j] && cntr[i] == 0)
                                        {
												
                                                colmax[j]=UM[i*N+j];					
                                                rowg[j]=i;
                                                colg[j]=j;
						cntr[i] = 1;
                                                cntrg[j]=1;
						vmarray[j]=i;
						System.out.println("vmarray[" + j + "] = " + vmarray[j]);
                                        }
                                }
                        }
                }
                
                for(j=0;j<N;j++)
                {
                        System.out.println("Resource #" + j + " has been scheduled to execute Request #" + rowg[j]);
                }
				value c = new value(colmax,rowg,colg,cntrg,vmarray);
                
				return c;
        }
        


	



   /**
	 * Submit cloudlets to the created VMs with FCFS discipline
	 * but submits n cloudlet a time where n is the number of free
	 * hosts\VMs.
	 *
	 * @pre $none
	 * @post $none
	 */
	@Override
	protected void submitCloudlets() 
	{

		System.out.println("\nSUBMITCLOUDLETS(), simulated time: " + CloudSim.clock());

		/*
		if(firstrun){
			//Collections.sort(getCloudletList(), new TimeComparator());
			occupation = new boolean[getVmsCreatedList().size()];
			for(int i = 0; i < occupation.length; i++)
				occupation[i] = false;

			firstrun = false;
		}
		*/

		System.out.println("CHECK0");
		double UMat[] = CreateUtil();
		/*
		for(int i=0;i<M;i++)
		for(int j=0;j<N;j++)
		System.out.println(UMat[i*N+j]);
		*/
		value lmax = LocalMax(UMat);
		value gmax = GlobalMax(lmax,UMat);
		int[] vmarray = gmax.va;
		double[] AM = CreateAlloc(gmax);
		for(int i=0;i<N;i++)
		System.out.println("vmarray[" + i + "] = " + vmarray[i]);
		/*
		for(Cloudlet c : getCloudletList())
		{
			for(int j=0;j<N;j++)
			{
				if(vmarray[j] )
				{
					c.setVmId(j);
				}
			}
		}
		*/

		/*
		int vmIndex = -1;
		value[] a= LocalMax(UM,M,N);
		value[] UtilMatrix= GlobalMax(a);
		*/
		
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i == vmarray[j])
					CloudletList.getById(getCloudletList(),i).setVmId(j);
			}
				
		}
	        //setCloudletList( Arrays.asList(c1) );      // How to convert array to List             
	
		for (Cloudlet cloudlet : getCloudletList()) 
		{
			Vm vm = VmList.getById(getVmsCreatedList(), cloudlet.getVmId());
			
			if (vm == null) 
			{ 	
				// vm was not created
				Log.printLine(CloudSim.clock() + ": " + getName() + ": Postponing execution of cloudlet " + cloudlet.getCloudletId() + ": bount VM not available");
				continue;
			}
			
			Log.printLine(CloudSim.clock() + ": " + getName() + ": Sending cloudlet " + cloudlet.getCloudletId() + " to VM #" + vm.getId());
			sendNow(getVmsToDatacentersMap().get(vm.getId()), CloudSimTags.CLOUDLET_SUBMIT, cloudlet);
			cloudletsSubmitted++;
			getCloudletSubmittedList().add(cloudlet);

			// set the assigned virtual machine as occupied
			
			occupation[vm.getId()] = true;
		}
		
		double AvgUtility = 0.0;
		int n=0;
		// remove submitted cloudlets from waiting list
		for (Cloudlet cloudlet : getCloudletSubmittedList()) {
			AvgUtility+=UMat[(cloudlet.getCloudletId()*N)+VmList.getById(getVmList(), cloudlet.getVmId()).getId()];
			n++;
			getCloudletList().remove(cloudlet);
		}
		AvgUtility/=n;
		System.out.println("Average Utility value = " + AvgUtility);
    }

		
    public double[] CreateAlloc(value cm)
    {
		double[] colmax = cm.n;
		int[] rowg = cm.r;
		int[] colg = cm.c;
    	double[] AllocMatrix = new double[M*N];
    	for(int j=0;j<colmax.length;j++)
        	AllocMatrix[rowg[j]*N + colg[j]]=colmax[j];
        return AllocMatrix;
    }
             
      


	/**
	 * Process a cloudlet return event.
	 *
	 * @param ev a SimEvent object
	 *
	 * @pre ev != $null
	 * @post $none
	 */
	@Override
	protected void processCloudletReturn(SimEvent ev) {
		Cloudlet cloudlet = (Cloudlet) ev.getData();



		getCloudletReceivedList().add(cloudlet);
		Log.printLine(CloudSim.clock()+": "+getName()+ ": Cloudlet "+cloudlet.getCloudletId()+" received from VM # " + cloudlet.getVmId());

		//occupation[cloudlet.getVmId()] = false;

		cloudletsSubmitted--;
		if (getCloudletList().size()==0 && cloudletsSubmitted==0) { //all cloudlets executed
			Log.printLine(CloudSim.clock()+": "+getName()+ ": All Cloudlets executed. Finishing...");
			clearDatacenters();
			finishExecution();
		} 

	/**		
		else { //some cloudlets haven't finished yet
			if (getCloudletList().size()>0 && cloudletsSubmitted==0) {
				//all the cloudlets sent finished. It means that some bount
				//cloudlet is waiting its VM be created
				//clearDatacenters();
				//createVmsInDatacenter(0);
			}

			if (getCloudletList().size()>0) {
				//all the cloudlets sent finished. It means that some bount
				//cloudlet is waiting its VM be created
				//clearDatacenters();
				//createVmsInDatacenter(0);
				submitCloudlets();  
			}

		} **/
	}

	/**
	 * Send an internal event communicating the end of the simulation.
	 *
	 * @pre $none
	 * @post $none
	 */
        @Override
	public void finishExecution() {
		sendNow(getId(), CloudSimTags.END_OF_SIMULATION);
	}
	
	
	

}



 class value
    {
        double[] n;
        int[] r;
        int[] c;
        int[] cn;
		int[] va;
		public value(){}
		public value(double[] n1,int[] r1,int[] c1,int[] cn1,int[] va1)
		{
			n=n1;
			r=r1;
			c=c1;
			cn=cn1;
			va=va1;
		}
		public value(double[] n1,int[] r1,int[] c1,int[] cn1)
		{
			n=n1;
			r=r1;
			c=c1;
			cn=cn1;
		}
    }








/*


List <Cloudlet> clist;
clist.getCloudletlist();

Cloudlet[5] c1;
int i = 0;

for (Cloudlet c :getCloudletList())
  c1[i++] = c;

Queue <Cloudlet> rqueue1;

rqueue.push_back(c1[i]);
rqueue.pop(c1);


*/
