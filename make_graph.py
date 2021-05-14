import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
import os

paths = os.listdir('output')


def check_dir(path):
    if not os.path.exists(path):
        os.makedirs(path)


def compare_algorithm_plot(dic, time_plot=True):

    for key, value_dic in dic.items():
        plot1 = plt.figure(1, figsize=(9, 6))
        make_plot(value_dic['best'], key, time_plot)
        plt.title('best case')
        plot2 = plt.figure(2, figsize=(9, 6))
        make_plot(value_dic['average'], key, time_plot)
        plt.title('average case')
        plot3 = plt.figure(3, figsize=(9, 6))
        make_plot(value_dic['worst'], key, time_plot)
        plt.title('worst case')

    label = 'time' if time_plot else 'count'
    plot1.savefig(os.path.join('plot\\algorithm_comparison',
                  'best_' + label + '_comparison.png'))
    plot2.savefig(os.path.join('plot\\algorithm_comparison',
                  'average_' + label + '_comparison.png'))
    plot3.savefig(os.path.join('plot\\algorithm_comparison',
                  'worst_' + label + '_comparison.png'))

    plt.close()
    plt.close()
    plt.close()


def make_plot(df, case, time_plot=True):
    size = df['size'].values
    time = df['time'].values
    count = df['count'].values
    y = time if time_plot else count
    ylabel = 'time' if time_plot else 'count'

    plt.plot(size, y, label=case)
    plt.legend()
    plt.xlabel('n')
    plt.ylabel(ylabel)

# corr = df.corr()
# plt.subplots(figsize=(15, 10))
# sns.heatmap(corr,xticklabels=corr.columns, yticklabels=corr.columns,
# annot=True,cmap=sns.diverging_palette(220, 20, as_cmap=True))
# plt.show()
'''
def make_heatmap(df, case, time_plot=True):
    size = df['size'].values
    time = df['time'].values
    count = df['count'].values
    y = time if time_plot else count
    ylabel = 'time' if time_plot else 'count'

    plt.subplot(figsize=(15,10))
    sns.heatmap(y, )
    pass
'''
def data_plot():
    complexity_dict = {}
    for path in paths:
        df = pd.read_csv(os.path.join('output', path))
        title = path.split('.')[0]
        check_dir(os.path.join('plot\\algorithm_info', title))

        df_best = df[df['type'] == 'best']
        df_average = df[df['type'] == 'average']
        df_worst = df[df['type'] == 'worst']
        plt.figure(figsize=(9, 6))
        make_plot(df_best, 'best')
        make_plot(df_average, 'average')
        make_plot(df_worst, 'worst')

        plt.title(title)
        plt.savefig(os.path.join(
            'plot\\algorithm_info\\' + title, 'time' + '.png'))
        plt.close()

        complexity_dict[title] = {'best': df_best,
                                  'average': df_average,
                                  'worst': df_worst}
        plt.figure(figsize=(9, 6))
        make_plot(df_best, 'best', time_plot=False)
        make_plot(df_average, 'average', time_plot=False)
        make_plot(df_worst, 'worst', time_plot=False)
        plt.title(title)

        plt.savefig(os.path.join(
            'plot\\algorithm_info\\' + title, 'count' + '.png'))
        plt.close()

    compare_algorithm_plot(complexity_dict)
    compare_algorithm_plot(complexity_dict, time_plot=False)


def main():
    data_plot()


if __name__ == "__main__":
    main()
