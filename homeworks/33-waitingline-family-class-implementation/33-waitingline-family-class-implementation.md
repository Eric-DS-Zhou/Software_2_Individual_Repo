# [Homework 33: WaitingLine Family Class Implementation][hw33]

- **Name**: EriC Zhou
- **Dot Number**: zhou.4898
- **Due Date**: Apr 14 @ 4:10 PM EST

## Preparation

Previous students would have wanted you to know the following
before you get started (based on 1 review):

- Estimated time to complete the assignment: 90 minutes
- Most common emotion before starting the assignment: ??
- Most common emotion while completing the assignment: ??
- Most common emotion after completing the assignment: ??

If the information above is incomplete, you can help by [providing
your own feedback][feedback-form] after completing this assignment.

## Problems

**This homework is necessary preparation for the lab.** Make sure you
type your answers in files you bring to the lab so that you will not
have to waste time entering your code during the lab.

### Problem 1

> For this homework, you will implement the WaitingLineSecondary class
> for the WaitingLine component family you worked on in the previous
> homework and lab. Starting from the class QueueSecondary, implement
> WaitingLineSecondary. WaitingLineSecondary should include implementation
> of the common methods: equals, hashCode, and toString, plus any enhanced
> methods you chose to include in your WaitingLine interface design. Note
> that there is no need to provide any methods beyond those needed to
> satisfy the requirements of the previous homework. In particular, you
> do not need to implement the Queue methods, unless you want to include
> any of them as part of WaitingLine. For this homework, turn in PDF print-outs
> of the WaitingLineSecondary.java file.

```java
public class WaitingLineSecondary<T> extends WaitingLine<T> { // ? implement or extends

    @Override
    public boolean equals(Object o) {
        boolean isEqual = true;
        if (o == null) {
            isEqual = false;
        } else if (!(o instanceof WaitingLine<?>)) {
            isEqual = false;
        } else {
            WaitingLine<?> other = (WaitingLine<?>) o;
            if (this.length() != other.length()) {
                isEqual = false;
            } else {
                Iterator<T> it1 = this.iterator();
                Iterator<?> it2 = other.iterator();
                while (it1.hasNext()) {
                    T x1 = it1.next();
                    Object x2 = it2.next();
                    if (isEqual && !x1.equals(x2)) {
                        isEqual = false;
                    }
                }
            }
        }
        return isEqual;
    }


    @Override
    public int hashCode() {
        int result = 1;
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            T x = it.next();
            result = 31 * result + x.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Iterator<T> it = this.iterator();
        boolean first = true;
        while (it.hasNext()) {
            T x = it.next();
            if (!first) {
                sb.append(", ");
            }
            sb.append(x);
            first = false;
        }
        sb.append(">");
        return sb.toString();
    }

    @Override
    public T front() {
        Iterator<T> it = this.iterator();
        T frontEntry = it.next();
        return frontEntry;
    }

    @Override
    public boolean contains(T x) {
        boolean found = false;
        Iterator<T> it = this.iterator();
        while (!found && it.hasNext()) {
            T current = it.next();
            if (current.equals(x)) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public T remove(T x) {
        int n = this.length();
        T removedEntry = this.removeFirst();
        int i = 1;

        while (!removedEntry.equals(x) && i < n) {
            this.add(removedEntry);
            removedEntry = this.removeFirst();
            i++;
        }

        while (i < n) {
            T front = this.removeFirst();
            this.add(front);
            i++;
        }

        return removedEntry;
    }

    @Override
    public int position(T x) {
        int pos = 0;
        int answer = -1;
        Iterator<T> it = this.iterator();
        while (answer < 0 && it.hasNext()) {
            T current = it.next();
            if(current.equals(x)){
                answer = pos;
            }
            pos++;
        }
        return answer;
    }
}
```

## Submission

If you have completed the assignment using this template, VS Code should
automatically convert the template to a PDF on save. If you're not automatically
getting a PDF, please reach out to the instructor. If you're in a rush to
submit, you may use one of the alternative strategies described in this
[Markdown to PDF guide][markdown-to-pdf-guide]. You may also consider printing
the raw markdown directly. However, do not make a habit of this as the graders
reserve the right to give a zero.

[hw32]: https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/homeworks/waiting-line-interfaces/waiting-line-interfaces.html
[feedback-form]: https://forms.gle/qJ1gEM5N1r6X7Poy5
[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
