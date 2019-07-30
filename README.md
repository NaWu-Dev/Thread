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
