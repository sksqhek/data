/**
 * 동적 배열 자료구조를 위한 인터페이스
 * @param <E> 자료형
 */
public interface DynamicSizable<E> {
  /**
   * item을 배열 끝에 추가
   * @param item
   */
  void add(E item);
  
  /**
   * item을 index 위치에 추가
   * @param index
   * @param item
   */
  void add(int index, E item);
  
  /**
   * 수용량을 반환
   * @return 수용량
   */
  int capacity();
  
  /**
   * 아이템이 없는 최초 상태로 만듬
   */
  void clear();
  
  /**
   * item을 가지고 있는지 여부를 반환
   * @param item
   * @return 가지고 있으면 true, 아니면 false를 반환
   */
  boolean contains(E item);
  
  /**
   * index 위치의 item을 반환
   * @param index
   * @return 해당 위치의 item
   */
  E get(int index);
  
  /**
   * item이 어느 위치에 있는지 반환
   * @param item
   * @return 존재하면 해당 index를, 없다면 -1을 반환
   */
  int indexOf(E item);
  
  /**
   * 비어있는 여부를 반환
   * @return 비어있다면 true, 아니면 false를 반환
   */
  boolean isEmpty();
  
  /**
   * index 위치의 item을 삭제
   * @param index
   * @return 삭제한 item을 반환
   */
  E remove(int index);
  
  /**
   * 몇개의 item을 가지고 있는지 반환
   * @return item 개수
   */
  int size();
  
  /**
   * index 위치에 item 변경 (덮어쓰기)
   * @param index
   * @param item
   * @return 변경되기 전 item을 반환
   */
  E set(int index, E item);
}
