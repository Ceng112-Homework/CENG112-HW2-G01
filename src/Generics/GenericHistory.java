package Generics;

import java.util.LinkedList;

// The GenericHistory class implements a generic undo/redo history mechanism.
// Might be we should to use any other way for undo/redo history, but we use LinkedList for now.
public class GenericHistory<T> {
    private LinkedList<T> undoStack = new LinkedList<>();
    private LinkedList<T> redoStack = new LinkedList<>();

    public void add(T action) {
        undoStack.push(action);   // adds to front
        redoStack.clear();        // new action clears redo history
    }

    public T undo() {
        if (!undoStack.isEmpty()) {
            T action = undoStack.pop();
            redoStack.push(action);
            return action;
        }
        return null;
    }

    public T redo() {
        if (!redoStack.isEmpty()) {
            T action = redoStack.pop();
            undoStack.push(action);
            return action;
        }
        return null;
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
