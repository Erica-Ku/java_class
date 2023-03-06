package Chap10_해시;

//체인법에 의한 해시
import java.util.Comparator;

import Chap10_해시.ChainHashTester.Data;

public class ChainHash<SimpleObject> {

 //--- 해시를 구성하는 노드 ---//
 class Node<SimpleObject> extends Data{
     //private K key;                 // 키값
     private SimpleObject data;                // 데이터
     private Node<SimpleObject> next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

     //--- 생성자(constructor) ---//
     Node(SimpleObject data, Node<SimpleObject> next) {
         //this.key  = key;
         this.data = data;
         this.next = next;
     }

     //--- 키값을 반환 ---//
//     K getKey() {
//         return key;
//     }

     //--- 데이터를 반환 ---//
     SimpleObject getValue() {
         return data;
     }

     //--- 키의 해시값을 반환 ---//
     public int hashCode() {
    	 return no.hashCode();
     }
     
     public Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

 	 public class NameOrderComparator implements Comparator<SimpleObject> {
 		public int compare(SimpleObject d1, SimpleObject d2) {
 			return (d1.toString().compareTo(d2.toString())>0) ? 1 : (d1.toString().compareTo(d2.toString())<0) ? -1 : 0;
 		}
 	}
 }

 private int    size;              // 해시 테이블의 크기
 private Node<SimpleObject>[] table;        // 해시 테이블

 //--- 생성자(constructor) ---//
 public ChainHash(int capacity) {
     try {
         table = new Node[capacity];
         this.size = capacity;
     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
         this.size = 0;
     }
 }

 //--- 해시값을 구함 ---//
 public int hashValue(Object data) {
     return data.hashCode() % size;
 }

 //--- 키값이 key인 요소를 검색(데이터를 반환) ---//
 public SimpleObject search(SimpleObject data) {
	 int hash = hashValue(data);        
     Node<SimpleObject> p = table[hash];           

     while (p != null) {
         if (p.NAME_ORDER.compare(p.getValue(), data)==0)
             return p.getValue();                
         p = p.next;                             
     }
     return null;
 }

 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
 public int add(SimpleObject data) {
     int hash = hashValue(data);
     Node<SimpleObject> p = table[hash];
     while (p!=null) {
    	 if(p.getValue().equals(data))
    		 return 1;
    	 p = p.next;
     }
     Node<SimpleObject> temp = new Node<SimpleObject>(data, table[hash]);
     table[hash] = temp;
     return 0;
 }

 //--- 키값이 key인 요소를 삭제 ---//
 public int remove(SimpleObject data) {
     int hash = hashValue(data);
     Node<SimpleObject> p = table[hash];
     Node<SimpleObject> pp = null;
     while (p!=null) {
    	 if(p.NAME_ORDER.compare(p.getValue(), data)==0) {
    		 if(pp==null) table[hash] = p.next;
    		 else pp.next = p.next;
    		 return 0;
    	 }
    	 pp = p;
    	 p = p.next;
     }
     return 1;
 }

 //--- 해시 테이블을 덤프(dump) ---//
 public void dump() {
     for (int i = 0; i < size; i++) {
    	 Node<SimpleObject> p = table[i];
    	 System.out.printf("%02d ", i);
    	 while (p!=null) {
    		 System.out.printf("→ (%s) ", p.getValue());
    		 p = p.next;
    	 }
    	 System.out.println();
     }
 }
}