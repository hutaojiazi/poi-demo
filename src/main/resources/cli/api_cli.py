import click
import requests

BASE_URL = 'http://localhost:8080/api'


@click.group()
def apis():
    """A CLI tool for the Trail API."""


@click.option('-t', '--clazz', help='Class of trail')
@click.option('-c', '--biketrail', help='bikeTrail is available')
@apis.command()
def trails(clazz: str, biketrail: str):
    """List all trails."""
    params = {
        'class': clazz,
        'bikeTrail': biketrail
    }

    response = requests.get(url=f'{BASE_URL}/trails', params=params)
    if response.status_code is 200:
        for i, entry in enumerate(response.json()['content']):
            pretty_entry = '\n'.join(f'{k}: {v}' for k, v in entry.items())
            print(f'{i + 1}.\n{pretty_entry}\n')
    else:
        print(f'Could not find the trails: {response.text}')


if __name__ == '__main__':
    apis(prog_name='apis')