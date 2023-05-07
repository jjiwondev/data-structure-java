package Interface;

/**
 * The interface List.
 * 자바 List Interface입니다. <br>
 * List는 ArrayList, SinglyLinkedList, DoublyLinked에 의해 각각 구현됩니다.
 *
 * @param <E> the type of elements in this list
 * @author Jiwon
 */
public interface List<E> {

    /**
     * 리스트에 요소를 추가.
     *
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우에 이미 중복되는 요소가 있을 경우
     *          {@code false}를 반환하고, 중복되는 원소가 없을 경우 리스트에 추가한 후
     *          {@code true}를 반환
     */
    boolean add(E value);

    /**
     * 리스트의 특정 위치에 요소를 추가.
     * 특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀림.
     *
     * @param index the index
     * @param value the value
     */
    void add(int index, E value);


}
