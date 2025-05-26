#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_WORD_LEN 100
#define TABLE_SIZE 10007  // Prime number for hash table size
#define TOP_N 10

typedef struct Bigram {
    char *first;
    char *second;
    int count;
    struct Bigram *next;
} Bigram;

Bigram *table[TABLE_SIZE];

unsigned long hash_bigram(const char *first, const char *second) {
    unsigned long hash = 5381;
    while (*first) hash = ((hash << 5) + hash) + *first++;
    while (*second) hash = ((hash << 5) + hash) + *second++;
    return hash % TABLE_SIZE;
}

char *str_duplicate(const char *str) {
    char *dup = malloc(strlen(str) + 1);
    if (dup) strcpy(dup, str);
    return dup;
}

void insert_bigram(const char *first, const char *second) {
    unsigned long h = hash_bigram(first, second);
    Bigram *curr = table[h];
    while (curr) {
        if (strcmp(curr->first, first) == 0 && strcmp(curr->second, second) == 0) {
            curr->count++;
            return;
        }
        curr = curr->next;
    }
    Bigram *new_node = malloc(sizeof(Bigram));
    new_node->first = str_duplicate(first);
    new_node->second = str_duplicate(second);
    new_node->count = 1;
    new_node->next = table[h];
    table[h] = new_node;
}

void normalize_word(char *word) {
    for (int i = 0; word[i]; i++) word[i] = tolower(word[i]);
}

void tokenize_words(FILE *fp, char ***words, int *word_count) {
    char buffer[MAX_WORD_LEN];
    int capacity = 1024;
    *words = malloc(capacity * sizeof(char*));
    *word_count = 0;

    while (fscanf(fp, "%99s", buffer) == 1) {
        normalize_word(buffer);
        if (*word_count >= capacity) {
            capacity *= 2;
            *words = realloc(*words, capacity * sizeof(char*));
        }
        (*words)[*word_count] = str_duplicate(buffer);
        (*word_count)++;
    }
}

void generate_bigrams(char **words, int word_count) {
    for (int i = 0; i < word_count - 1; i++) {
        insert_bigram(words[i], words[i + 1]);
    }
}

int compare_bigrams(const void *a, const void *b) {
    Bigram *ba = *(Bigram**)a;
    Bigram *bb = *(Bigram**)b;
    return bb->count - ba->count;
}

void get_top_n_bigrams(Bigram **top, int *total_bigrams) {
    Bigram **all = malloc(sizeof(Bigram*) * 100000);
    int count = 0;
    for (int i = 0; i < TABLE_SIZE; i++) {
        Bigram *curr = table[i];
        while (curr) {
            all[count++] = curr;
            curr = curr->next;
        }
    }
    *total_bigrams = count;
    qsort(all, count, sizeof(Bigram*), compare_bigrams);
    for (int i = 0; i < TOP_N && i < count; i++) top[i] = all[i];
    free(all);
}

void write_output_file(const char *filename, Bigram **top, int top_n, int total_bigrams) {
    FILE *fp = fopen(filename, "w");
    if (!fp) return;
    fprintf(fp, "Total bigrams: %d\n", total_bigrams);
    fprintf(fp, "Top %d bigrams:\n", top_n);
    for (int i = 0; i < top_n; i++) {
        if (!top[i]) break;
        fprintf(fp, "%s %s: %d\n", top[i]->first, top[i]->second, top[i]->count);
    }
    fclose(fp);
}

void free_table() {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Bigram *curr = table[i];
        while (curr) {
            Bigram *tmp = curr;
            curr = curr->next;
            free(tmp->first);
            free(tmp->second);
            free(tmp);
        }
    }
}

int main() {
    FILE *fp = fopen("input.txt", "r");
    if (!fp) {
        perror("Failed to open input file");
        return 1;
    }

    char **words;
    int word_count;
    tokenize_words(fp, &words, &word_count);
    fclose(fp);

    generate_bigrams(words, word_count);

    Bigram *top[TOP_N] = {0};
    int total_bigrams = 0;
    get_top_n_bigrams(top, &total_bigrams);

    write_output_file("output.txt", top, TOP_N, total_bigrams);

    for (int i = 0; i < word_count; i++) free(words[i]);
    free(words);
    free_table();
    return 0;
}
