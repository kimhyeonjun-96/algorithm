package data_structure;

/*
* 1. 간단한 개념 설명
*   순서를 가진 같은 데이터들의 조합
*   **생성과 동시에 크기가 고정!**
*   전체 원소가 메모리상에 일렬로 저
*
* 2. 배열의 기능
*   a. get(int idx) : idx번째 원소 반환
*      메모리가 연속적이기에 arr의 시작 주소로부터 idx만큼 떨어진 원소의 주소를 바로 계산하고 접근
*   b. change(int idx, int val) : idx번째 원소를 val로 변경
*      [] 연산자를 통해 idx번 원소에 바로 접근하고 값을 변경
*   c. append(int idx, int val) : 가장 뒤에 원소 삽입 ( 가능하다면 )
*      현재 배열에 담진 원소의 개수를 알면 해당 인덱스에 요청 받은 원소를 넣는다.
*      단, 배열은 한번 생성된 배열의 길이는 고정!
*      원소들이 연속되어 있는 배열의 마지막에 원소를 추가할 때 이미 배열이 꽉 찼다면 그보다 큰 새 배열을 생성해 옮겨 담아야 한다.
*   d. insert(int idx, int val) : 현재 idx번째 원소의 앞에 원소 삽입
*      원소들이 연속되어 있는 배열의 중간에 원소를 추가하기 위해서는 추가되는 원소의 뒷 원소들이 모두 한 칸씩 뒤로 이동해 새 원소를 삽입할 수 있는 자리를 만들어야 한다.
*   e. erase(int idx) : idx번째 원소 삭제
*      원소들이 연속되어 있는 배열의 중간 원소를 삭제할때는 해당 원소의 뒷 원소들을 모두 한 칸씩 앞으로 이동해야한다.
* 3. 요약
*   원소에 접근하고 변경은 빠름
*   중간 원소를 추가/삭제는 최대 배열 원소의 개수까지 시간이 걸림
* */
public class DataStructure_array {
    public static void main(String[] args) {
        // 배열 생성
        int[] arr1 = new int[5];
        for(int i=0; i< arr1.length; i++){
            // 배열 데이터 저장
            arr1[i] = i+1;
        }
        int sum = 0;
        for(int i=0; i< arr1.length; i++){
            sum += arr1[i]; // 1 + 2 + 3 + 4 + 5 = 15, 배열 탐색 및 원소 접근
        }
        System.out.println("arr1 sum = " + sum); // 15 출력

        // 원하는 값으로 배열 생성
        sum = 0;
        int[] arr2 = {10, 9, 8, 7, 6};
        for(int i=0; i<arr2.length; i++){
            sum += arr2[i]; // 10 + 9 + 8 + 7 + 6 = 40, 배열 탐색 및 원소 접근
        }
        System.out.println("arr2 sum = " + sum);

        // 1. 배열 기능 - get(int idx)
        System.out.println(getElement(arr2, 4)); // 6 반환

        // 2. 배열 기능 - change(int idx, int val)
        changeElement(arr2, 4, 999); // 4번 위치에 있는 원소 6을 999로 변경
        System.out.println(getElement(arr2, 4)); // 999 반환

        // 3. 배열 기능 - append(int idx, int val)
        if(appendElemnet(arr2, arr2.length, 1))
            System.out.println(getElement(arr2, arr2.length));
        else System.out.println("끝 추가 실패");

        // 4. 배열 기능 - insert(int idx, int val)
        if(insertElement(arr2, arr2.length, 4, 2))
            System.out.println(getElement(arr2, arr2.length));
        else System.out.println("중간 추가 실패");

        // 5. 배열 기능 - erase(int idx)
        if(eraseElement(arr2, arr2.length, 4))
            for(int i=0; i<arr2.length; i++){
                System.out.println(i+" : "+arr2[i]);
            }
    }
    private static int getElement(int[] arr, int idx){
        return arr[idx];
    }
    private static void changeElement(int[] arr, int idx, int val){
        arr[idx] = val;
    }
    private static boolean appendElemnet(int[] arr, int length, int val){
        if(length == arr.length){
            return false;
        }
        arr[length] = val;
        return true;
    }
    private static boolean insertElement(int[] arr, int length, int idx, int val){
        if(idx > length || length >= arr.length){
            return false;
        }
        for(int i=length; i>idx; i--){
            arr[i] = arr[i-1];
        }
        arr[idx] = val;
        return true;
    }
    private static boolean eraseElement(int[] arr, int length, int idx){
        if(idx >= length){
            return false;
        }
        for(int i=idx; i<length; i++){
            if(i+1 == length){
                arr[i] = 0;
                return true;
            }
            arr[i] = arr[i+1];
        }
        return true;
    }
}
