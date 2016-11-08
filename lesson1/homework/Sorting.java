class Sorting {
		public static void main(String[] args){
		
				Human[] humanArray = new Human[6];
				for (int i=0; i < humanArray.length; i++){
					humanArray[i] = new Human();
				}

				humanArray[0].name = "Sam";
				int marksOfSam[] = {5, 5, 4, 4, 4, 3, 3, 3};
			  humanArray[0].marks = marksOfSam;
				double averageMarksOfSam = getAverageMarks(humanArray[0].marks);
				humanArray[0].averageMark = averageMarksOfSam;

				 
				humanArray[1].name = "Jack";
				int marksOfJack[] = {4, 4, 4, 3, 3, 3};
			  humanArray[1].marks = marksOfJack;
				humanArray[1].averageMark = getAverageMarks(humanArray[1].marks);

				humanArray[2].name = "Alex";
				int marksOfAlex[] = {5, 4, 4, 4, 3, 3, 3};
			  humanArray[2].marks = marksOfAlex;
				humanArray[2].averageMark = getAverageMarks(humanArray[2].marks);

				humanArray[3].name = "Ivan";
				int marksOfIvan[] = {5, 5, 3, 3, 3};
			  humanArray[3].marks = marksOfIvan;
				humanArray[3].averageMark = getAverageMarks(humanArray[3].marks);

				humanArray[4].name = "Kostya";
				int marksOfKostya[] = {5, 2, 3, 1, 3};
			  humanArray[4].marks = marksOfKostya;
				humanArray[4].averageMark = getAverageMarks(humanArray[4].marks);

				humanArray[5].name = "Jeremy";
				int marksOfJeremy[] = {4, 2, 1, 2, 5};
			  humanArray[5].marks = marksOfJeremy;
				humanArray[5].averageMark = getAverageMarks(humanArray[5].marks);
				sort(humanArray);

				for (int i=0; i < humanArray.length; i++) {
					System.out.println(humanArray[i].averageMark);
				}
		}
				private static int heapSize;

				public static void sort(Human[] a){
					buildHeap(a);
					while (heapSize > 1) {
						swap(a, 0, heapSize - 1);
						heapSize--;
						heapify(a, 0);
					}
				}

				private static void buildHeap(Human[] a) {
					heapSize = a.length;
					for (int i = a.length / 2; i >= 0; i--) {
						heapify(a, i);
					}
				}

				private static void heapify(Human[] a, int i) {
					int l = left(i);
					int r = right(i);
					int largest = i;
					if (l < heapSize && a[i].averageMark < a[l].averageMark) {
						largest = l;
					}
					if (r < heapSize && a[largest].averageMark < a[r].averageMark) {
						largest = r;
					}
					if (i != largest) {
						swap(a, i, largest);
						heapify(a, largest);
					}
				}

				private static int right(int i) {
					return 2 * i + 1;
				}

				private static int left(int i) {
					return 2 * i + 2;
				}

				private static void swap(Human[] a, int i, int j) {
					Human temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}

						

				public static double getAverageMarks(int[] a){

					double b = 0;
					for (int i=0; i<a.length; i++) {
						if (a[i] != 0){
							b += a[i];
						}
					}
					double c = (b / a.length);
					return c;
				}
}
