# Midterm 1 Coding Questions

## Question 1 Set on array of set

```java

public final void add(T x) {

    int index = mod (x.hashCode(), this.hashTable.length);
    this.hashTable[index].add(x);
    this.size++;

}

public final T remove(T x){

    int index = mod (x.hashCode(), this.hashTable.length);
    T result = this.hashTable[index].remove(x);
    this.size--;

    return result;

}

public final boolean contains(T x){

    int index = mod (x.hashCode(), this.hashTable.length);
    boolean result = this.hashTable[index].contains(x);

    return result;
}

```

## Question 2 Whether the binaryTree is balanced or not

```java

BinaryTree: t
method: Isbalanced

public static <T> boolean isBalanced(BinaryTree <T> t){

    boolean result = true;

    if (t.size() > 2) {

        BinaryTree<T> left = t.newInstance();
        BinaryTree<T> right = t.newInstance();
        T root = t.disassemble(left, right);

        if (Math.abs(left.height() - right.height()) > 1) {
            result = false;
        } else {
            result = isBalanced(left) && isBalanced(right);
        }

        t.assemble(root, left, right);
    }

    return result;
}

```

## Question 3 NaturalNumber on Sequence

```java

Follow Project 2
Sequence: rep
Convention: no leading zero
Correspondace: use <0> to represent 0

public final void multiplyBy10(int k){

    if (this.rep.length() == 1){
        int digit = this.rep.remove(0);
        if(digit == 0) {
            this.rep.add(0, k);
        } else {
            this.rep.add(0, digit);
            this.rep.add(1, k);
        }
    } else {
        this.rep.add(this.rep.length(), k);
    }
}

public final int divideBy10(){

    int result = this.rep.remove(this.rep.length() - 1);
    if (this.rep.length() == 0) {
        this.rep.add(0, 0);
    }

    return result;
}

public final boolean isZero(){

    boolean result = false;

    if (this.rep.length() == 1) {
        int digit = this.rep.remove(0);
        if (digit == 0) {
            result = true;
        }
        this.rep.add(0, digit);
    }

    return result;

}

```
