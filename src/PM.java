/* PM is 524,288 addresses
 * PM divided into 1024 frames, 512 words per frame
 * PA is 19 bits
 * ST is in frame 0, occupies 1 page
 * PT(s) occupy 2 consecutive pages
 * Page(s) occupy 1 page
 * 
 * 
 *
 */


public class PM {

	final private String pageFaultMessage = "pf";
	final private String doesNotExistError = "error";
	final int size = 524288;
	final int numFrames = 1024;
	private int[] segmentTable = new int[1024];
	private int[] mainMemory = new int[size];
	private boolean[] bitmap = new boolean[1024];
	
	
	public PM(int[] starray, int[] pagearray) {
		initilize(starray, pagearray);
	}
	
	private void initilize(int[] ptarray, int[] pagearray){
		for (int i=0; i<ptarray.length;i=i+2) {
			segmentTable[ptarray[i]] = ptarray[i+1];
			int pa = ptarray[i+1];
			if (pa != -1) {
				int frameNumber = ptarray[i+1] / 512;
				bitmap[frameNumber] = true;	
			}
		}
		for (int i=0; i<pagearray.length;i=i+3) {
			mainMemory[segmentTable[pagearray[i+1]]+pagearray[i]] = pagearray[i+2];
			int pa = pagearray[i+2];
			if (pa != -1) {
				int frameNumber = pagearray[i+2] / 512; 
				bitmap[frameNumber] = true;
			}
		}
		
		// need to create bitmap 
	}
	
	public void read(){
		
	}
	
	public void write() {
		
		
	}
	
	class SegmentTable {
		
	}
}
