# [Homework 21: Tree and Recursion][hw21]

- **Name**: Eric Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Mar 6 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 60 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

The following problems will give you practice with trees and recursion.

### Problem 1

> Write a recursive body for the following static, generic
> method that computes and returns the size of a given Tree<T>.
> You can use any of the Tree methods except for the iterator
> and the size kernel method. Note that the Tree must be restored,
> i.e., its outgoing value must be the same as its incoming value.

```java
/**
 * Returns the size of the given {@code Tree<T>}.
 *
 * @param <T>
 *            the type of the {@code Tree} node labels
 * @param t
 *            the {@code Tree} whose size to return
 * @return the size of the given {@code Tree}
 * @ensures size = |t|
 */
public static <T> int size(Tree<T> t) {

    int result = 0;

    if (t.height() == 0){
        result = 0;
    } else {
        Sequence<Tree<T>> children = t.newSequenceOfTree();
        T root = t.disassemble(children);
        result = 1;

        for (int i = 0; i < children.length(); i++){
            result = result + size(children.entry(i));
        }

        t.assemble(root, children);

    }
    return result;
}
```

### Problem 2

> Provide a second implementation of the size method above but
> this time make it an iterative (non-recursive) solution. You
> still cannot use the size kernel method in your solution.

```java
    public static <T> int size(Tree<T> t) {
        int result = 0;
        for (T x : t) {
            result++;
        }

        return result;
    }

```

### Problem 3

> Write a recursive body for the following static, generic method
> that computes and returns the height of a given Tree<T>. You
> can use any of the Tree methods except for the height kernel
> method (in particular, you can use the size method). Note that
> the Tree must be restored, i.e., its outgoing value must be the
> same as its incoming value.

```java
/**
 * Returns the height of the given {@code Tree<T>}.
 *
 * @param <T>
 *            the type of the {@code Tree} node labels
 * @param t
 *            the {@code Tree} whose height to return
 * @return the height of the given {@code Tree}
 * @ensures height = ht(t)
 */
public static <T> int height(Tree<T> t) {
    int result = 0;

    if (t.size() == 0){
        result = 0;
    } else {
        Sequence<Tree<T>> children = t.newSequenceOfTree();
        T root = t.disassemble(children);

        int maxChildrenHeight = 0;

        for (int i = 0; i < children.length(); i++){
            int childrenHeight = height(children.entry(i));
            if (childrenHeight > maxChildrenHeight) {
                maxChildrenHeight = childrenHeight;
            }
        }
        result = 1 + maxChildrenHeight;

        t.assemble(root, children);

    }
    return result;
}
```

### Problem 4

> Write a recursive body for the following static method that computes
> and returns the largest integer in a given non-empty Tree<Integer>.
> Note that the Tree must be restored, i.e., its outgoing value must
> be the same as its incoming value.

```java
/**
 * Returns the largest integer in the given {@code Tree<Integer>}.
 *
 * @param t
 *            the {@code Tree<Integer>} whose largest integer to return
 * @return the largest integer in the given {@code Tree<Integer>}
 * @requires |t| > 0
 * @ensures <pre>
 * max is in labels(t)  and
 * for all i: integer where (i is in labels(t)) (i <= max)
 * </pre>
 */
public static int max(Tree<Integer> t) {...}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw21]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/tree.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
