word = input()
result = ''
min_word = word[:1][::-1] #0~1
separator_index = 1

#0~i
for i in range(2,len(word)-2):
    word1= word[:i:][::-1]
    if word1<min_word:
        min_word=word1
        separator_index=i
result+=min_word 

min_word= word[separator_index:separator_index+1][::-1]
separator_index2 = separator_index+1
for j in range(separator_index+2,len(word)):
    word2= word[separator_index:j:][::-1]
    if word2<min_word:
        min_word=word2
        separator_index2=j
result+=min_word                 
result+=word[separator_index2:][::-1]
print(result)
