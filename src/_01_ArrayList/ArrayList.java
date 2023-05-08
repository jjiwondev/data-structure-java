package _01_ArrayList;

import Interface.List;

import java.util.Arrays;


/**
 * The type Array list.
 *
 * @param <E> the type of elements in this list
 */
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10; //최소 용적 크기
    private static final Object[] EMPTY_ARRAY = {}; //빈 배열

    private int size; //요소 개수

    Object[] array; //요소를 담을 배열

    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }
    public ArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){
        int array_capacity = array.length;
        //array의 capacity가 0인 경우
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }
        //용량이 꽉 찰 경우(2배 증가)
        if(size == array_capacity){
            int newCap = array_capacity*2;
            array = Arrays.copyOf(array, array_capacity);
            return;
        }
        //용적의 절반 미만으로 요소가 차지하고 있을 경우(2배 감소)
        if( size < array_capacity/2){
            int newCap = array_capacity/2;
            array = Arrays.copyOf(array, Math.max(newCap,DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    private void addLast(E value) {
        if(size == array.length ){
            resize();
        }
        array[size] = value;
        size++;
    }
    @Override
    public void add(int index, E value) {
        if( index<0 || index> size ){
            throw new IndexOutOfBoundsException();
        }
        if( size == index ){// 맨 마지막에 들어가는 경우
            addLast(value);
        }else {// 중간에 인덱스가 들어가는 경우
            //사이즈가 같은 경우
            if(size == array.length){
                resize();
            }
            //하나씩 요소미루기
            for(int i = size; i>index; i--){
                array[i] = array[i-1];
            }
            //인덱스에 요소 넣기
            array[index] = value;
            size++;
        }
    }
    public void addFirst(E value){
        add(0,value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        Object removed;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        removed = array[index];
        if(index == size-1){//맨 끝의 요소를 삭제하는 경우
            array[index] = null;
        }else{
            for(int i = index; i<size; i++){
                array[i] = array[i+1];
            }
        }
        size--;
        resize();
        return (E)removed;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        if(index == -1){
            return false;
        }

        remove(index);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if(index >= size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if(index >= size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean contains(Object value) {
        if(indexOf(value) >= 0 ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0; i<size; i++){
            if( array[i].equals(value) ){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(Object value){
        for(int i = size-1; i>-1; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        //모든 공간 null 처리
        for(int i = 0; i<size; i++){
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        // 새로운 객체 생성
        ArrayList<?> cloneList = (ArrayList<?>)super.clone();

        // 새로운 객체의 배열도 생성해주어야 함 (객체는 얕은복사가 되기 때문)
        cloneList.array = new Object[size];

        // 배열의 값을 복사함
        System.arraycopy(array, 0, cloneList.array, 0, size);

        return cloneList;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }


    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // copyOf(원본 배열, 복사할 길이, Class<? extends T[]> 타입)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        // 원본배열, 원본배열 시작위치, 복사할 배열, 복사할배열 시작위치, 복사할 요소 수
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }
}
