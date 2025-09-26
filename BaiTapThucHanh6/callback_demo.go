package main

import (
    "fmt"
    "sync"
    "time"
)

func caller(id int, wg *sync.WaitGroup) {
    defer wg.Done()
    time.Sleep(50 * time.Millisecond)
    fmt.Printf("caller.go() called: id=%d\n", id)
}

func main() {
    var wg sync.WaitGroup
    n := 10
    wg.Add(n)
    for i := 0; i < n; i++ {
        go caller(i, &wg) 
    }
    wg.Wait()
    fmt.Println("All callers finished.")
}
