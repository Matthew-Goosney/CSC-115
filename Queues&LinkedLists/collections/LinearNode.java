package collections;

/**
 * A single node for a singly-linked list
 */
public class LinearNode<T> {

  /** element stored at this node */
  private T element = null;
  /** Link to the next node in list */
  private LinearNode<T> next;

  /**
   * Creates an empty node
   */
  public LinearNode() {
    next = null;
    element = null;
  }

  /**
   * Creates a node storing the specified element
   * @param element element to be stored
   */
  public LinearNode(T element) {
    this.element = element;
    next = null;
  }

  /**
   * Creates a node storing the specified element and the specified node
   * @param element Item to be stored
   * @param next Reference to the next node in the list
   */
  public LinearNode(T element, LinearNode<T> next) {
    this.element = element;
    this.next = next;
  }

  /**
   * Returns the element stored at this node
   * @return T element stored element at this node
   */
  public T getElement() {
    return element;
  }

  /**
   * Set the reference to the stored element
   * @param element The item to be stored at this node
   */
  public void setElement(T elem) {
    element = elem;
  }

  /**
   * Returns the next node
   * @return SinglyLinkedNode&lt;T&gt; reference to next node
   */
  public LinearNode<T> getNext() {
    return next;
  }

  /**
   * Sets the reference to the next node in the list
   * @param next The next node
   */
  public void setNext(LinearNode<T> node) {
    next = node;
  }
  
  
  
}