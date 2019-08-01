# Thread Tech Points
## Inter Thread Communication
Use wait() and notify() to implement a simple Queue. 
* wait()
* notify()
* synchronized
* sleep()
>### Wait() vs Sleep()
> - wait() is defined in Object class, sleep() is defined in Thread class;
> - wait() releases the lock and monitor, sleep() doesn't release lock or monitor; 
> - wait() is used for inter-thread communication, sleep() is used for pause current thread for a specific duration; 
> - wait() is called from Sychronized context, sleep() can be called without Sychronized; 
> - wiating thread can be awake by notify() or notifyAll()

## Deadlock with Nested Synchronized Block
A deadlock demo with nested synchronized block. This demo demonstrates one thread holds a lock on one object and waiting for another object locks which are held by another thread. 
> ### How to avoid Deadlock? 
> - Avoid nested locks. Always acquire locks in the same order. For example, to fix the deadlock in demo, just need to change the order of synchronized block.
> - Avoid unnecessary locks. Lock particular field of object instead of locking whole object. 
> - Use thread join().

## ThreadPool and Executors
Thread pool reuse previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. 
> ### Stesp to creat ExecutorService: 
> - Create a task (Runnable object) to execute
> - Create ExecutorService using Executors
> - ExecutorService executes the tasks
> - Shutdown the ExecutorService
> _(refer to package: executorService)_
> ### ExecutorService Methods: 
> - newFixedThreadPool(int)
> - newCachedThreadPool()
> - newSingleThreadExecutor()
> ### Runnable vs Callable
> Runnable interface is similar with Callable interface. Both interfaces represent a task that can be executed concurrently by a thread or ExecutorService. Main different between Runnalbe interface and Callable interface are: 
> - Runnable interface has run() method, Callable interface has call() method which can return an object from the call. 
> - call() method can throw an Exception, run() method cannot. 
> _(refer to package: callable)_ 
