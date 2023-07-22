use GuzzleHttp\Client;

$client = new Client([
    // Remplacez l'adresse IP par celle de votre serveur si nécessaire
    'base_uri' => 'http://localhost:7000', 
]);

$response = $client->request('GET', '/');

echo $response->getBody();