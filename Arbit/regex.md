# Regex

A regular expression defines a search pattern for strings. Regular expressions can be used to search, edit and manipulate text.

---

`^\d+(\.\d+)?`

^ defines that the patter must start at beginning of a new line. \d+ matches one or several digits. The ? makes the statement in brackets optional. \. matches ".", parentheses are used for grouping. Matches for example "5", "1.5" and "2.21".

##  Common matching symbols

![regex_basics](./_image/regex_basics.png)

## Meta characters

The following meta characters have a pre-defined meaning and make certain common patterns easier to use.  e.g., \d instead of [0..9].

![regex_meta_character](./_image/regex_meta_character.png)

```
\   	Escape the next meta-character (it becomes a normal/literal character)
^   	Match the beginning of the line
.   	Match any character (except newline)
$   	Match the end of the line (or before newline at the end)
|   	Alternation (‘or’ statement)
()  	Grouping
[]  	Custom character class
```

## Quantifier

A quantifier defines how often an element can occur. The symbols ?, *, + and {} define the quantity of the regular expressions.

![regex_quantifiers](./_image/regex_quantifiers.png)

