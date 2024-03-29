## Talk plan

### Google Closure Compiler

https://github.com/google/closure-compiler

Basically same thing as tscc + rollup, but much more powerful

Started somewhere around 2003th
Open-Sourced in 2009

Node.js was first released in 2009
npm followed  in 2010

implemented in Java

* No ECMAScript
* IE5 support
* No NodeJS (because no webkit)
* No EsModules (because no ECMAScript)
* No TypeScript or whatever

### Why it's not popular ?

Java
Lack of evangelism

Bloat (which is funny, because nowadays `node_modules` for
simple TS + React app is 232M)

### Couple of good articles:

https://effectivetypescript.com/2023/09/27/closure-compiler/
and https://news.ycombinator.com/item?id=37686633 - discussion

* https://developer.chrome.com/blog/migrating-to-typescript/
* https://www.lucidchart.com/techblog/2017/11/16/converting-600k-lines-to-typescript-in-72-hours/


### Command line usage

```
java -jar /Users/deshilov/.m2/repository/com/google/javascript/closure-compiler-unshaded/v20220502/closure-compiler-unshaded-v20220502.jar \
     --warning_level VERBOSE \
     --js test.js
```


### Standard library

Annotated JS code with bunch of functions
