# Midterm 2 coding quesitions

## Question 1 Empty Tree

```java

public static int emptyTree(Tree<T> t) {
    int count = 0;
    if (t.size() == 0) {
        count = 1;
    } else {
        Sequence<Tree<T>> children = t.newSequenceOfTree();
        T root = t.disassemble(children);
        int length = children.length();
        for (int i = 0; i < length; i++) {
            Tree<T> child = children.remove(i);
            count = count + emptyTree(child);
            children.add(i, child);
        }
        t.assemble(root, children);
    }

    return count;
}

```

## Question 2 Kernel Implementation

```java

public final void addRightFront(T x) {
    Node newNode = new Node();
    newNode.data = x;
    newNode.next = this.lastleft.next;
    this.lastleft.next = newNode;
}

public final void advanve() {
    this.lastleft = this.lastleft.next;
}

public final int rightLength() {
    int length = 0;
    Node p = this.lastleft.next;
    while (p != null) {
        length++;
        p = p.next;
    }

    return length;
}

```

## Question 3 Refactor

```java

public static void refactor(Statement s) {
    switch (s.kind()) {
        case BLOCK: {
            int length = s.lengthOfBlock();
            for (int i = 0; i < length; i++) {
                Statement bl = s.removeFromBlock(i);
                refactor(bl);
                s.addToBlock(i, bl);
            }

            break;
        }

        case CALL: {
            String name = s.disassembleCall();
            if (name.equals("move")) {
                Statement block = s.newInstance();
                s.assembleCall(name);
                block.addToBlock(0, s);
                s.assembleIf(Statement.Condition.NEXT_IS_EMPTY, block);
            } else {
                s.assembleCall(name);
            }
        }
    }
}

```
