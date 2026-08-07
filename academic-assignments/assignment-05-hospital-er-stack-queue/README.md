# Assignment 05: Hospital Emergency Room Stack And Queue

## Topic / Concept Focus

This learning exercise focused on using a linked-list-based queue and stack in a hospital emergency room simulation.

## Task Summary

The task involved creating a hospital emergency room system using `StackAsMyLinkedList` and `QueueAsMyLinkedList`. The queue managed admitted patients, with emergency patients receiving priority. The stack stored treated patients so the system could undo the most recent treatment if needed.

The system demonstrated admitting patients, treating patients, undoing treatments, displaying the current queue and stack status, and handling attempts to treat a patient when the queue was empty.

## Data Structures Used

- Linked-list-based queue
- Linked-list-based stack
- Patient records or patient objects
- Priority handling for emergency patients

## Main Operations

- Admit a patient into the queue.
- Give emergency patients priority in the queue.
- Treat the next patient.
- Push treated patients onto the stack.
- Undo the most recent treatment using the stack.
- Display waiting patients and treated patients.
- Handle empty queue cases safely.

## What I Learned

- How queues can model first-in, first-out waiting systems.
- How stacks can support undo behaviour.
- How linked lists can be used to build custom stack and queue structures.
- Why emergency-priority logic needs careful placement in the queue.
- How real-world scenarios can make abstract data structures easier to understand.

## How I Would Improve It Now

- Separate patient data, queue logic, stack logic, and menu logic into different classes.
- Make the emergency-priority behaviour clearer and easier to test.
- Add stronger input validation.
- Add sample test cases for treating patients, undoing treatments, and empty queue handling.
- Document the time complexity of the main operations.

## Source Files

Source files will be added later after review and cleanup.
